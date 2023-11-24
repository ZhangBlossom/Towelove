package blossom.project.towelove.common.constant;

/**
 * @projectName: Towelove
 * @package: blossom.project.towelove.common.constant
 * @className: UserConstants
 * @author: Link Ji
 * @description: TODO
 * @date: 2023/11/23 23:58
 * @version: 1.0
 */
public class UserConstants {
    /**
     * 用户签到位图key,%d表示年份，%s表示userId;
     */
    public static final String USER_SIGN_IN_KEY = "user_signIn_%d:%s";

    public static final String USER_TOTAL_SIGN_IN_KEY = "user_totoal_sign:%s";

    public static final String USER_TYPE_PHONE = "1";

    public static final String USER_TYPE_EMAIL = "2";
    public static final String USER_TYPE_QQ = "3";
    public static final String USER_TYPE_WEIXIN = "4";
}
