package com.aspira.parser.leonbets.constants;

public class URLConstants {
    public static final String BASE_URL = "https://leonbets.com/api-2/betline/";

    public static final String MATCH_REQUEST = "/event/all";
    public static final String SPORT_REQUEST = "/sports";
    public static final String LEAGUE_REQUEST = "/events/all";

    public static final String SPORT_QUERY_PARAMETERS = "?ctag=en-US&flags=urlv2";
    public static final String LEAGUE_QUERY_PARAMETERS = "?ctag=en-US&hideClosed=true&flags=reg,urlv2,mm2,rrc,nodup&league_id=";
    public static final String MATCH_QUERY_PARAMETERS = "?ctag=en-US&flags=reg,urlv2,mm2,rrc,nodup,smg,outv2&eventId=";
}
