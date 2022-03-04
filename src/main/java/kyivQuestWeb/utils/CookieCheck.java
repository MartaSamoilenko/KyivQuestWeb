package kyivQuestWeb.utils;

import javax.servlet.http.HttpServletRequest;

public abstract class CookieCheck {
    public abstract Boolean check(HttpServletRequest request);
}
