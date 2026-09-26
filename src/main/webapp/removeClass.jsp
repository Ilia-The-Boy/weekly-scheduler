<%@ page import="com.iijee.class_scheduler.model.Days" %>
<%@ page import="com.iijee.class_scheduler.model.Meeting" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
    <table class="has-actions">
        <%Days day = (Days) request.getAttribute("day");%>
        <thead>
            <tr>
                <th>
                    class name
                </th>
                <th>
                    period
                </th>
                <th>
                    action
                </th>
            </tr>
        </thead>
        <tbody>

        <%for (Meeting meeting : day.getMeetingList()){%>
            <tr>
                <td><%=meeting.getName()%></td>
                <td><%=meeting.getStartingTime()%> - <%=meeting.getEndingTime()%></td>
                <td> <button class="btn-remove" onclick="remove(<%=day.getId()%>, <%=meeting.getId()%>)">Remove class</button> </td>
            </tr>
        <%}%>
<%--            <tr>--%>
<%--                <td>--%>
<%--                    class id--%>
<%--                </td>--%>
<%--                <%for (Meeting meeting : day.getMeetingList()){%>--%>
<%--                <th><%=meeting.getId()%></th>--%>
<%--                <%}%>--%>
<%--            </tr>--%>
        </tbody>
    </table>
<%--    <br>--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    <form action="/schedule/<%= day.getId()%>" method="post">--%>
<%--        <label for="classId">class id</label>--%>
<%--        <input required type="number" id="classId" name="classId">--%>
<%--        <br>--%>
<%--        <input type="submit" value="remove">--%>
<%--    </form>--%>
<script>
    function remove(day_id, meeting_id){
    // document.location.replace("/schedule/" + id +"d")
        const response = fetch("/schedule/"+ day_id +"/"+ meeting_id,{
            method: "DELETE"
        })
    alert("class removed from !")
    }
    </script>
</body>
</html>
