package com.keithkoberle.custom;
import jdk.nashorn.internal.ir.IfNode;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.time.temporal.ChronoUnit;

public class TimeDateOperations extends SimpleTagSupport {
    private LocalDateTime NYSEDateTime;
    private LocalDateTime now;
    private Integer currentESTHour;
    private LocalDate holiday;


    /**
     *  @return the LocalDate holiday
     */
    public LocalDate getHoliday() {
        return holiday;
    }

    /**
     * Sets holiday.
     *
     * @param holiday the LocalDate holiday
     */
    public void setHoliday(LocalDate holiday) {
        this.holiday = holiday;
    }


    /**
     * Project Implementation
     * <p>
     * public LocalDateTime getNYSEDateTime() {
     * return NYSEDateTime;
     * }
     * public void setNYSEDateTime(LocalDateTime NYSEDateTime) {
     * this.NYSEDateTime = NYSEDateTime;
     * }
     */




    /**
     *  @return the LocalDateTime now
     */
    public LocalDateTime getNow() {
        return now;
    }

    /**
     * Sets now.
     *
     * @param now the LocalDateTime now
     */
    public void setNow(LocalDateTime now) {
        this.now = now;
    }


    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        this.now = LocalDateTime.now();

        // Set Holiday to Halloween
        this.holiday = LocalDate.of(now.getYear(), 10, 31);

        // check to see what appropriate message for time of day is and output
        if (now.getHour() > 16) {
            out.println("Good Evening<br />");
        } else if (now.getHour() > 12) {
            out.println("Good Afternoon<br />");
        } else if (now.getHour() >= 0) {
            out.println("Good Morning<br />");
        } else {
            out.println("Good " + now.getDayOfWeek() + " to you, I didn't think of how you got here.<br />");
        }

        // check for holiday and display approp. message either way.
        if (now.getMonth() == holiday.getMonth() && now.getDayOfMonth() == holiday.getDayOfMonth()) {
            out.println("And a spooky Halloween to you!");
        } else {
            out.println("And have a good day for the rest of your " +  now.getDayOfWeek().toString().toLowerCase() + ".");
        }


        /**
         *  Beginning of Implementation for checking time to get stock info
         *

        this.NYSEDateTime = LocalDateTime.now(ZoneId.of("America/New_York"));

        if(currentESTHour == null) {
            this.currentESTHour = NYSEDateTime.getHour() - 1;
        }




        if(NYSEDateTime.getHour() > currentESTHour) {
            out.println("Time to get another stock quote.<br />");
            currentESTHour++;
        }

        out.println("Current EST time is :" + NYSEDateTime.getNano());

         */









    }





}
