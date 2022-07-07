import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class LocalDateTest {
    public static void main(String[] args) {

        // A. LocalDate
        // 1. 생성하기
        // 1-1. 직접 연월일 지정
        LocalDate date = LocalDate.of(2022, 8, 3);
        // 1-2. 컴퓨터 시스템 날짜 얻기
        LocalDate today = LocalDate.now();

        // 2. 연,월,일 정보 얻기
        // 2-1. getYear(), getMonthValue(), getDayOfMonth()
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("오늘은 %d년 %d월 %d일\n", year, month, day);

        // 2-2. TemperalField로 정보 얻기
        year = today.get(ChronoField.YEAR);
        month = today.get(ChronoField.MONTH_OF_YEAR);
        day = today.get(ChronoField.DAY_OF_MONTH);
        System.out.printf("오늘은 %d년 %d월 %d일\n", year, month, day);

        // B. LocalTime
        // 1. 생성하기
        // 1-1. 직접 시간, 분, 초 지정
        LocalTime time1 = LocalTime.of(14, 6, 12);
        LocalTime time2 = LocalTime.of(14, 6); //초 생략 가능
        // 1-2. 컴퓨터 시스템 시간 얻기
        LocalTime time3 = LocalTime.now();

        // 2. 시간, 분, 초 얻기
        // 2-1. getHour(), getMinute(), getSecond()
        int hour = time3.getHour();
        int minute = time3.getMinute();
        int second = time3.getSecond();
        System.out.printf("현재 시각은 %d시 %d분 %d초\n", hour, minute, second);

        // C. LocalDateTime : LocalDate + LocalTime, 날짜와 시간 모두 표현 가능
        // 1. 생성하기
        // 1-1. 직접 년,월,일,시,분,초 작성
        LocalDateTime dt1 = LocalDateTime.of(2022, 1, 1, 12, 25, 30);
        // 1-1' LocalDate와 LocalTime을 인자로 받을 수 있다.
        LocalDateTime dt2 = LocalDateTime.of(today, time3);

        // 1-2. 컴퓨터 시스템 날짜&시간 얻기
        LocalDateTime dt3 = LocalDateTime.now();

        // 2. 연월일 & 시간, 분, 초 얻기
        year = dt3.getYear();
        month = dt3.getMonthValue();
        day = dt3.getDayOfMonth();
        hour = dt3.getHour();
        minute = dt3.getMinute();
        second = dt3.getSecond();
        System.out.printf("오늘은 %d년 %d월 %d일, 현재 시각 %d시 %d분 %d초\n", year, month, day, hour, minute, second);

        // D. Formatting과 Parsing
        // 1. DateTimeFormatter로 포맷팅하기
        LocalDate date2 = LocalDate.of(2080, 11, 2);
        String s1 = date2.format(DateTimeFormatter.BASIC_ISO_DATE); //20801102
        String s2 = date2.format(DateTimeFormatter.ISO_LOCAL_DATE); //2080-11-02

        // 2. parse메소드로 날짜를 나타내는 문자열을 파싱하여 날짜 객체 생성
        LocalDate date3 = LocalDate.parse("20601122", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date4 = LocalDate.parse("2060-11-22", DateTimeFormatter.ISO_LOCAL_DATE);

    }
}
