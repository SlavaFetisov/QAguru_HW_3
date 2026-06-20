package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CloseAd {
    public static void closeAd() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
    }
}