<%@ page import="java.io.File" %>

<%!
    public String getFiles(String path, String match, String notMatch, HttpServletRequest request) {
        File dir = new File(request.getSession().getServletContext().getRealPath(path));

        String[] files = dir.list();
        StringBuilder builder = new StringBuilder();

        File temp;
        String newPath;

        for (String f : files) {
            if (f.indexOf(match) != -1 && (notMatch == null || (notMatch != null && f.indexOf(notMatch) == -1))) {
                newPath = request.getContextPath() + path + '/' + f;
                builder.append("<script src=\"" + newPath + "\"></script>\r\n");
            } else {
                newPath = path + '/' + f;
                temp = new File(request.getSession().getServletContext().getRealPath(newPath));
                if (temp.isDirectory()) {
                    builder.append(getFiles(newPath, match, notMatch, request));
                }
            }
        }

        return builder.toString();
    }
%>