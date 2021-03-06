package model.Connection;

public class Queries {

	public final static String REG_SEL_USER_ID_MAP = "SELECT USER_ID FROM USER_ID_MAP WHERE ROLL_NO = ? OR EMAILID = ?";
	
	public final static String REG_INS_USER_ID_MAP ="INSERT INTO USER_ID_MAP(ROLL_NO,EMAILID)VALUES(?,?)";
	public final static String REG_INS_USER_LOGIN ="INSERT INTO USER_LOGIN (USER_ID,PASSWORD)VALUES(?,?)";
	public final static String REG_INS_USER_PROF_DETAILS = "INSERT INTO USER_PROF_DETAILS (USER_ID,USER_NAME,PROFILE_PIC,GENDER,COURSE_ID,PHONE_NO)VALUES(?,?,?,?,?,?)";
	public final static String REG_INS_USER_INTERESTS ="INSERT INTO USER_INTERESTS (USER_ID,INTEREST_ID)VALUES(?,?)";	
	
	public final static String LOGIN_SEL_USER_ID_MAP_USER_LOGIN  = "SELECT UI.USER_ID FROM USER_ID_MAP UI,USER_LOGIN UL WHERE (ROLL_NO = ? OR EMAILID = ?) AND UI.USER_ID = UL.USER_ID AND UL.PASSWORD = ?";
	public final static String LOGIN_SEL_USER_PROF_DETAILS = "SELECT U.USER_NAME,U.PROFILE_PIC, U.GENDER, U.COURSE_ID,C.COURSE_DESC, U.PHONE_NO FROM USER_PROF_DETAILS U,COURSE C WHERE U.USER_ID = ? AND C.COURSE_ID = U.COURSE_ID";
	public final static String LOGIN_SEL_USER_INTERESTS = "SELECT U.INTEREST_ID,I.INTEREST_DESC FROM USER_INTERESTS U,INTEREST I WHERE U.USER_ID = ? AND U.INTEREST_ID = I.INTEREST_ID";
	
	public final static String NEWS_INS_USER_POST_DETAILS   =  "INSERT INTO USER_POST_DETAILS(USER_ID,POST_CONTENT)VALUES(?,?)";
	public final static String NEWS_SEL_USER_FRND_MAP_USER_POST_DETAILS_USER_PROF_DETAILS = "SELECT USER_NAME,PROFILE_PIC,POST_CONTENT,POST_TIMESTAMP FROM USER_POST_DETAILS UP,USER_PROF_DETAILS UPR WHERE ((UP.USER_ID IN(SELECT UF.FRND_ID FROM USER_FRND_MAP UF WHERE UF.USER_ID = ? )) OR (UP.USER_ID = ?)) AND UP.USER_ID = UPR.USER_ID ORDER BY POST_TIMESTAMP DESC";
	
	public final static String FRND_INS_USER_FRND_MAP   = "INSERT INTO USER_FRND_MAP(USER_ID,FRND_ID)VALUES(?,?)";
	
	public final static String SEARCH_SEL_USER_ID_MAP_USER_PROF_DETAILS_USER_FRND_MAP = "SELECT UI.USER_ID, UP.USER_NAME,UP.PROFILE_PIC,CASE WHEN UI.USER_ID NOT IN (SELECT UF.FRND_ID FROM USER_FRND_MAP UF WHERE UF.USER_ID = ?) THEN 'N' ELSE 'Y' END AS FRND  FROM USER_ID_MAP UI,USER_PROF_DETAILS UP WHERE(UI.ROLL_NO LIKE ? OR UI.EMAILID LIKE ?) AND UI.USER_ID = UP.USER_ID AND UI.USER_ID NOT IN (?)";
	
	
	
	public final static String MASTER_COURSE = "SELECT COURSE_ID,COURSE_DESC FROM COURSE";
	public final static String MASTER_INTEREST = "SELECT INTEREST_ID,INTEREST_DESC FROM INTEREST";
												
						
}
