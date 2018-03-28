<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- 富文本编辑器引入文件 -->
<script type="text/javascript" src="../../ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="../../ueditor/ueditor.all.js"></script>

<style>
    body {
        background: #f0f4ff;
    }
</style>

<body style="width:95%;height:100% ;overflow:auto">
<div style="padding:10px 10px 20px 10px">
    <form id="" method="post">
        <table cellpadding="5"  style="font-size: 14px">
            <tr>
                <td>新闻内容:</td>
                <td><textarea  name="news" id="news"></textarea></td>
            </tr>
        </table>
    </form>
</div>
</body>

<script>
    //ueditor编辑器
    UE.getEditor('news');
</script>


<!-- 富文本编辑器引入文件 -->
<script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="../ueditor/ueditor.all.js"></script>

<style>
    body {
        background: #f0f4ff;
    }
</style>

<span style="color:#FF0000;"><body style="width:95%;height:100% ;overflow:auto"></span>
<div style="padding:10px 10px 20px 10px">
    <form id="actionform" method="post">
        <table cellpadding="5"  style="font-size: 14px">
            <tr>
                <td>新闻内容:</td>
                <td><textarea  name="news" id="news"></textarea></td>
            </tr>
        </table>
    </form>
</div>
</body>

<script>
    //ueditor编辑器
    UE.getEditor('news');
</script>