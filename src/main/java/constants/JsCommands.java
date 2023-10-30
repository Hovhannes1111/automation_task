package constants;

public interface JsCommands {
    String CLOSE_AD = "arguments[0].style.display = 'none';";
    String SCROLL_BOTTOM_OF_PAGE = "window.scrollTo(0,document.body.scrollHeight);";
    String SCROLL_TO_VIEW_ELEMENT = "arguments[0].scrollIntoView(true);";
    String WAIT_FOR_PAGE_TO_LOAD = "return document.readyState";
}
