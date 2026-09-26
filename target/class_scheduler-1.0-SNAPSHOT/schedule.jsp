<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="com.iijee.class_scheduler.model.Days" %>
<%@ page import="com.iijee.class_scheduler.model.Time" %>
<%@ page import="com.iijee.class_scheduler.model.Meeting" %>
<%@ page import="java.time.Duration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>schedule</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
    <h1>weekly plan</h1>

    <table class="has-actions" >
        <colgroup>
            <col style="width: 10%">   <!-- day name -->
            <col style="width: 7.5%">  <!-- 9-10 -->
            <col style="width: 7.5%">  <!-- 10-11 -->
            <col style="width: 7.5%">  <!-- 11-12 -->
            <col style="width: 7.5%">  <!-- 12-13 -->
            <col style="width: 7.5%">  <!-- 13-14 -->
            <col style="width: 7.5%">  <!-- 14-15 -->
            <col style="width: 7.5%">  <!-- 15-16 -->
            <col style="width: 7.5%">  <!-- 16-17 -->
            <col style="width: 20%">   <!-- actions -->
        </colgroup>
        <thead>
        <tr>
            <th>☺</th> <th>9-10</th> <th>10-11</th> <th>11-12</th> <th>12-13</th> <th>13-14</th> <th>14-15</th> <th>15-16</th> <th>16-17</th> <th>actions</th>
        </tr>
        </thead>
        <tbody>


        <% String meetingName = "";%>
        <%Long meetingId = -1L;%>
        <%for (Days day : (List<Days>) request.getAttribute("plan")){%>
        <%long duration = 0;%>
        <%LocalTime skipPoint = LocalTime.of(8, 0);%>

        <tr>
            <td><%= day.getName()%></td>
            <%for (Time time : day.getIterablePlan()){%>
            <%if (time.isOccupied()){%>
                <%if (time.getTime().isBefore(skipPoint)) continue;%>
                <%for (Meeting meeting : day.getMeetingList()){%>
                    <%if (time.getTime().equals(meeting.getStartingTime())){%>
                        <%duration = Duration.between(meeting.getStartingTime(), meeting.getEndingTime()).toHours();%>
                        <%skipPoint = meeting.getEndingTime();%>
                        <%meetingName = meeting.getName();%>
                        <%meetingId = meeting.getId();%>
                        <%break;}%>

                <%}%>
                <td colspan="<%=duration%>"><%=meetingName%></td>
            <%}else if (!time.isAvailable()){%>
            <td>unavailable</td>
            <%}else {%>
            <td>---</td>
            <%}%>
<%--            <td>--%>
<%--                <%if (time.isOccupied()){%>--%>
<%--                    <%for (Meeting meeting : day.getMeetingList()){%>--%>
<%--                        <%if (time.getTime().equals(meeting.getStartingTime())){%>--%>
<%--                            <%meetingName = meeting.getName();%>--%>
<%--                            <%meetingId = meeting.getId();%>--%>
<%--                        <%}%>--%>
<%--                    <%}%>--%>
<%--                <%}%>--%>
<%--                <%=time.isOccupied()? "occupied by class "+ meetingName +", id: "+ meetingId : time.isAvailable() ? "---" : "unavailable"%>--%>

<%--            </td>--%>
            <%}%>
            <td>
                <button class="btn-add" onclick="addClass(<%=day.getId()%>)">Add class</button>
                <button class="btn-remove" onclick="removeClass(<%=day.getId()%>)">Remove class</button>
            </td>
        </tr>
        <%}%>

        </tbody>
    </table>

<script>
    async function addClass(id){
        document.location.replace("/schedule/p" + id)
    }

    function removeClass(id){
        document.location.replace("/schedule/d" + id)
    }
</script>
</body>
</html>