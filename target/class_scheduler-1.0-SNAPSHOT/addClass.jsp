<%@ page import="java.time.LocalTime" %>
<%@ page import="com.iijee.class_scheduler.model.Days" %>
<%@ page import="com.iijee.class_scheduler.model.Time" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adding class</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>☺</th> <th>9-10</th> <th>10-11</th> <th>11-12</th> <th>12-13</th> <th>13-14</th> <th>14-15</th> <th>15-16</th> <th>16-17</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <%Days day = (Days) request.getAttribute("day");%>
        <td><%= day.getName()%></td>
        <%for (Time time : day.getIterablePlan()){%>
        <td>
            <%=time.isOccupied()? "occupied" : time.isAvailable() ? "free" : "unavailable"%>
        </td>
        <%}%>
<%--        <td>--%>
<%--            <button onclick="addClass(<%=day.getId()%>)">Add class</button>--%>
<%--            <button onclick="removeClass(<%=day.getId()%>)">Remove class</button>--%>
<%--        </td>--%>
    </tr>


    </tbody>
</table>
<br>
<br>
<br>
                <form action="/schedule/<%= day.getId()%>" method="post">
                    <div class="field">
                        <label for="className">class name</label>
                        <input required type="text" id="className" name="className">
                    </div>
                    <div class="field">
                        <label for="start">starting time</label>
                        <input required type="time" id="start" name="startingTime">
                    </div>
                    <div class="field">
                        <label for="end">ending time</label>
                        <input required type="time" id="end" name="endingTime">
                    </div>
                    <input class="btn-add" type="submit" value="add">
                </form>

</body>
</html>
