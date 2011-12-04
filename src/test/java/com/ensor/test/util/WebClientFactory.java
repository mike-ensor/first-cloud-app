package com.ensor.test.util;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.util.FalsifyingWebConnection;
import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

public class WebClientFactory {

    /* The WebClient class is NOT thread safe */
    private static WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3_6);

    private WebClientFactory() {
    }

    public static WebClient getWebClient() {
        return getWebClient(false);
    }

    public static WebClient getWebClientWithWebtrends() {
        return getWebClient(true);
    }

    @VisibleForTesting
    static boolean isWebTrendsUrl(WebRequest request) {
        // check for "accepts text/javascript
        String searchStr = request.getUrl().toString();
        return StringUtils.containsIgnoreCase(searchStr, "webtrends");
    }

    private static WebClient getWebClient(boolean withWebtrends) {
        webClient.setThrowExceptionOnScriptError(false);
        webClient.setThrowExceptionOnFailingStatusCode(false);
        if (!withWebtrends) {
            webClient.setWebConnection(new FalsifyingWebConnection(webClient) {
                @Override
                public WebResponse getResponse(final WebRequest request) throws IOException {
                    if (isWebTrendsUrl(request)) {
                        return createWebResponse(request, "", "application/javascript"); // -> empty script
                    }
                    return super.getResponse(request);
                }
            });
        }
        return webClient;
    }
}
