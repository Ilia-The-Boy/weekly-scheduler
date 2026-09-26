package com.iijee.class_scheduler.servlet;

import com.iijee.class_scheduler.connection.ConnectionProvider;
import com.iijee.class_scheduler.model.Days;
import com.iijee.class_scheduler.services.AddClass;
import com.iijee.class_scheduler.services.RemoveClass;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/schedule/*")
public class ScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = new ConnectionProvider().getEntityManager();
        if (req.getPathInfo() != null){
            Long id = Long.parseLong(req.getPathInfo().substring(2));
            String action = req.getPathInfo().substring(1).replace(req.getPathInfo().substring(2), "");
            Days day = entityManager.find(Days.class, id);
            req.setAttribute("day", day);
            req.getRequestDispatcher(action.equals("p")? "/addClass.jsp" : "/removeClass.jsp").forward(req, resp);
        }else {


            List<Days> plan = new ArrayList<>();
            for (long i = 1L; i <= 6L; i++)
                plan.add(entityManager.find(Days.class, i));
            req.setAttribute("plan", plan);
            req.getRequestDispatcher("/schedule.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getPathInfo().substring(1));
        LocalTime startingTime = LocalTime.parse(req.getParameter("startingTime"));
        LocalTime endingTime = LocalTime.parse(req.getParameter("endingTime"));
        String className = req.getParameter("className");

        boolean successfulAdding = false;

        if (req.getParameter("startingTime").trim().isEmpty() || req.getParameter("endingTime").trim().isEmpty() || req.getParameter("className").trim().isEmpty()){
            System.out.println("blank???");
        }else {
            successfulAdding = AddClass.authenticateAvailableTime(id, className, startingTime, endingTime);
            System.out.println(successfulAdding? "successfully added" : "something went wrong");

            resp.sendRedirect("/schedule");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo().substring(1).trim().isEmpty()){
            System.out.println("what?");
        }else {

            String pathInfo = req.getPathInfo().substring(1);
            int slashIndex = pathInfo.indexOf('/');
            Long dayId = Long.parseLong(pathInfo.replace(pathInfo.substring(slashIndex), ""));
            Long meetingId = Long.parseLong(pathInfo.substring(slashIndex + 1));
            RemoveClass.removeMeeting(dayId, meetingId);
        }




    }
}
