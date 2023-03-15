<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书注册</title>
    <style>
        table {
            color: lightseagreen;
            margin: 0 auto;
            table-layout: fixed;
            width: 65%;
            border: 2px dashed cornflowerblue;
            border-collapse: collapse;
            opacity: 0.89;
        }

        table:hover {
            color: #66f9cf;
            margin: 0 auto;
            table-layout: fixed;
            width: 65%;
            border: #66f9cf 2px dashed;
            border-collapse: collapse;
            opacity: 0.89;
        }

        td {
            text-align: center;
        }

        caption {
            font-style: inherit;
            font-size: 2em;
            padding: 20px;
            color: lightseagreen;
            caption-side: top;
            letter-spacing: 0.1em;
            opacity: 0.8;
        }

        caption:hover {
            font-style: inherit;
            font-size: 2em;
            padding: 20px;
            color: #66f9cf;
            caption-side: top;
            letter-spacing: 0.1em;
            opacity: 0.8;
        }

        input {
            color: mediumslateblue;
            background-color: aliceblue;
            font-size: 20px;
            border: 2px dashed cornflowerblue;
            border-radius: 10px;
        }

        input:hover {
            color: lavender;
            background-color: slateblue;
            border: 2px dotted aquamarine;
            border-radius: 10px;
        }

        .container {
            background: lavender;
        }

        button {
            color: mediumslateblue;
            background-color: aliceblue;
            font-size: 20px;
            border: 2px dashed cornflowerblue;
            border-radius: 10px;
        }

        button:hover {
            color: lavender;
            background-color: slateblue;
            border: 2px dotted aquamarine;
            border-radius: 10px;
        }

    </style>
</head>
<body>
<form id="frmBook"
      name="frmBook"
      method="post"
      action="/bookadd">
    <table width="600px" align="center">
        <tr>
            <td>
                图书注册
            </td>
        </tr>
        <tr>
            <td>
                <table width="100%"
                       cellspacing="0"
                       cellpadding="5"
                       border="1">
                    <tr>
                        <td>图书编号:</td>
                        <td>
                            <input type="text" name="bookId">
                        </td>
                    </tr>
                    <tr>
                        <td>图书名称:</td>
                        <td>
                            <input type="text" name="bookName">
                        </td>
                    </tr>
                    <tr>
                        <td>图书价格:</td>
                        <td>
                            <input type="text" name="bookPrice">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center">
                <button type="submit">添加</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
