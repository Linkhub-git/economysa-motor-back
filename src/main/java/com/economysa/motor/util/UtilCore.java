package com.economysa.motor.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author QuickDev
 */
public class UtilCore {

    private static Calendar cal;

    static {
        cal = Calendar.getInstance();
    }

    public static class UtilDate {

        public static Date initDay(Date date) {
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            return cal.getTime();
        }

        public static Date endDay(Date date) {
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 0);

            return cal.getTime();
        }

        public static Date fechaActual() {
            ZoneId actualZone = ZoneId.systemDefault();
            ZonedDateTime actualZonedDatetime = LocalDateTime.now().atZone(actualZone);
            ZoneId limaZone = ZoneId.of("America/Lima");
            ZonedDateTime limaDatetime = actualZonedDatetime.withZoneSameInstant(limaZone);

            return Date.from(limaDatetime.toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant());
        }

        public static boolean isBeforeOrEqualToday(Date date) {
            cal.add(Calendar.DATE, 1);
            return cal.getTime().before(date);
        }

        public static Date removeTime(Date date) {
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            return cal.getTime();
        }

        public static Date limitDayTime(Long date) {
            cal.setTime(new Date(date));
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 0);
            return cal.getTime();
        }

        public static Date dayBefore() {
            Date today = fechaActual();
            cal.setTime(today);

            cal.add(Calendar.DATE, -1);
            return cal.getTime();
        }

        public static String formatDate(Date date) {
            cal.setTime(date);

            String day = getDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
            String month = getMonth(cal.get(Calendar.MONTH));
            int year = cal.get(Calendar.YEAR);

            return day + " " + cal.get(Calendar.DAY_OF_MONTH) + " de " + month + ", " + year;
        }

        public static boolean isSunday(Date date) {
            cal.setTime(date);

            return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
        }

        public static boolean isBetween(Date date, int hourInit, int hourEnd) {
            cal.setTime(date);
            int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);

            return hourOfDay >= hourInit && hourOfDay < hourEnd;
        }

        public static boolean isNextDay(Long time) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(new Date(time));

            Calendar c2 = Calendar.getInstance();
            c2.add(Calendar.DAY_OF_MONTH, 1);

            return c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
        }

        public static boolean shouldBlockDay(Long time) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(new Date(time));

            int day = c1.get(Calendar.DAY_OF_MONTH);

            return (day == 20) || (day == 21) || (day == 22) || (day == 23);
        }

        public static boolean isMonday(Long time) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(new Date(time));

            return c1.get(Calendar.DAY_OF_WEEK) == 2;
        }

        public static boolean isSaturday(Long time) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(new Date(time));

            return c1.get(Calendar.DAY_OF_WEEK) == 7;
        }

        public static boolean isTuesday(Long time) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(new Date(time));

            return c1.get(Calendar.DAY_OF_WEEK) == 3;
        }

        public static boolean isWednesday(Long time) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(new Date(time));

            return c1.get(Calendar.DAY_OF_WEEK) == 4;
        }

        public static boolean passedCutTime() {
            Calendar c = Calendar.getInstance();
            c.setTime(UtilDate.fechaActual());

            return c.get(Calendar.HOUR_OF_DAY) >= 16;
        }

        public static Date addDaysAndRemoveTime(int days) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, days);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return c.getTime();
        }

        public static Calendar addDaysAndRemoveTime(Calendar c, int days) {
            c.add(Calendar.DAY_OF_MONTH, days);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return c;
        }

        public static Date removeTime(Long date) {
            cal.setTime(new Date(date));
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            return cal.getTime();
        }

        private static String getDayOfWeek(int day) {
            String text = "";
            switch (day) {
                case 1:
                    text = "Domingo";
                    break;
                case 2:
                    text = "Lunes";
                    break;
                case 3:
                    text = "Martes";
                    break;
                case 4:
                    text = "Miércoles";
                    break;
                case 5:
                    text = "Jueves";
                    break;
                case 6:
                    text = "Viernes";
                    break;
                case 7:
                    text = "Sábado";
                    break;
            }
            return text;
        }

        private static String getMonth(int month) {
            String text = "";
            switch (month) {
                case 0:
                    text = "Enero";
                    break;
                case 1:
                    text = "Febrero";
                    break;
                case 2:
                    text = "Marzo";
                    break;
                case 3:
                    text = "Abril";
                    break;
                case 4:
                    text = "Mayo";
                    break;
                case 5:
                    text = "Junio";
                    break;
                case 6:
                    text = "Julio";
                    break;
                case 7:
                    text = "Agosto";
                    break;
                case 8:
                    text = "Setiembre";
                    break;
                case 9:
                    text = "Octubre";
                    break;
                case 10:
                    text = "Noviembre";
                    break;
                case 11:
                    text = "Diciembre";
                    break;
            }
            return text;
        }
    }

    public static class UtilPrices {
        public static BigDecimal format(int offset, BigDecimal value) {
            return value.setScale(offset, BigDecimal.ROUND_UP);
        }

        public static BigDecimal format(BigDecimal value) {
            return value.setScale(2, BigDecimal.ROUND_DOWN);
        }

        public static BigDecimal calculatePercentage(BigDecimal percentage, BigDecimal amount) {
            return percentage.multiply(amount).divide(new BigDecimal(100))
                .setScale(2, RoundingMode.HALF_DOWN);
        }
    }

    public static class UtilSecurity {
        public static String generatePassword() {
            return UUID.randomUUID().toString().substring(0, 8);
        }
    }
}
