package com.qualitestgroup.serenity.cucumber.features.utils;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.qualitestgroup.serenity.cucumber.features.utils.Utils.stripFrontRegex;

public class ScheduleParser {

    private static String dowRegex = "(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)";
    private static String typeRegex = "(WINE|BEER|SPIRITS)";
    private static String timeRegex = "(\\d{1,2}:\\d{2}\\s(am|pm))";
    private static String timeRangeRegex = "(" + timeRegex + "\\s-\\s" + timeRegex + ")";
//    private static String tastingTypeDayTime = typeRegex+"\\s"+dowRegex+"\\s("+timeRegex+"\\s-\\s"+timeRegex+")";
    private static String tastingTypeDayTime = typeRegex + "\\s" + dowRegex + "\\s" + timeRangeRegex + "\\s?";
//    private static String tastingDayTime = "\\s+"+dowRegex+"\\s\\d{1,2}:\\d{2}\\s(am|pm)\\s-\\s\\d{1,2}:\\d{2}\\s(am|pm)";
    private static String tastingDayTime = "\\s?" + dowRegex + "\\s"+ timeRangeRegex;
//    private static String normalDayTime = dowRegex+"\\s\\d{1,2}:\\d{2}\\s(am|pm)\\s-\\s\\d{1,2}:\\d{2}\\s(am|pm)\\s?";
    private static String normalDayTime = dowRegex+"\\s" + timeRangeRegex + "\\s?";

    // T A S T I N G   T A B ------------------------------------------------------------------------------v
    public static boolean isTypeDayTimeFound(String hoursStream) {
        Pattern pattern = Pattern.compile(tastingTypeDayTime);
        Matcher matcher = pattern.matcher(hoursStream);
        boolean found = false;
        if (matcher.find()) {
//            System.out.println("found (all) --> " + matcher.group());
//            System.out.println("found --> " + matcher.group(1));
//            System.out.println("found --> " + matcher.group(2));
//            System.out.println("found --> " + matcher.group(3));
//            System.out.println("found --> " + matcher.group(4));
//            System.out.println("found --> " + matcher.group(5));
//            System.out.println("found --> " + matcher.group(6));
            int index = matcher.start();
            if (index < 2) {
                found = true;
            }
        }
        return found;
    }
    public static boolean isDayTimeFound(String hoursStream) {
        Pattern pattern = Pattern.compile(tastingDayTime);
        Matcher matcher = pattern.matcher(hoursStream);
        boolean found = false;
        if (matcher.find()) {
            System.out.println("found (all) --> " + matcher.group());
            int index = matcher.start();
            if (index == 0) {
                found = true;
            }
        }
        return found;
    }
    public static String stripTypeDayTime(String hoursStream) {
        return stripFrontRegex(hoursStream, tastingTypeDayTime);
    }
    public static String stripDayTime(String hoursStream) {
        return stripFrontRegex(hoursStream, tastingDayTime);
    }
    public static String getDayFromDayTime(String hoursStream) {
        String result = "NOT FOUND!";
        Pattern pattern = Pattern.compile(tastingDayTime);
        Matcher matcher = pattern.matcher(hoursStream);
        if (matcher.find()) {
            result = matcher.group(1);
        } else {
            throw new IllegalStateException("No match for day in " + hoursStream + "!");
        }
        return result;
    }
    public static String getHoursFromDayTime(String hoursStream) {
        String result = "NOT FOUND!";
        Pattern pattern = Pattern.compile(tastingDayTime);
        Matcher matcher = pattern.matcher(hoursStream);
        if (matcher.find()) {
            result = matcher.group(2);
        } else {
            throw new IllegalStateException("No match for hours in " + hoursStream + "!");
        }
        return result;
    }
    public static String getTypeFromTypeDayTime(String hoursStream) {
        String result = "NOT FOUND!";
        Pattern pattern = Pattern.compile(tastingTypeDayTime);
        Matcher matcher = pattern.matcher(hoursStream);
        if (matcher.find()) {
            result = matcher.group(1);
        } else {
            throw new IllegalStateException("No match for type in " + hoursStream + "!");
        }
        return result;
    }
    public static String getDayFromTypeDayTime(String hoursStream) {
        String result = "NOT FOUND!";
        Pattern pattern = Pattern.compile(tastingTypeDayTime);
        Matcher matcher = pattern.matcher(hoursStream);
        if (matcher.find()) {
            result = matcher.group(2);
        } else {
            throw new IllegalStateException("No match for day in " + hoursStream + "!");
        }
        return result;
    }
    public static String getHoursFromTypeDayTime(String hoursStream) {
        String result = "NOT FOUND!";
        Pattern pattern = Pattern.compile(tastingTypeDayTime);
        Matcher matcher = pattern.matcher(hoursStream);
        if (matcher.find()) {
            result = matcher.group(3);
        } else {
            throw new IllegalStateException("No match for hours in " + hoursStream + "!");
        }
        return result;
    }
    public static String getHoursForDay(String hoursStream, DayOfWeek dayOfWeek) {
        String result = "NOT FOUND!";
        Locale locale = Locale.getDefault();
        String day = dayOfWeek.getDisplayName(TextStyle.FULL, locale);
        String regEx = day + "\\s" + timeRangeRegex;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(hoursStream);
        if (matcher.find()) {
            result = matcher.group().replace(day+" ", "");
        }
        return result;
    }
}
