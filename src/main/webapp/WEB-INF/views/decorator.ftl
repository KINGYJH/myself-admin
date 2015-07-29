<!DOCTYPE html>
<!--
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
-->
<html lang="zh_cn">
<head>
    [@block name = "Meta"]
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="YJH">
    <link rel="shortcut icon" href="[@spring.url '/resources/images/favicon.ico' /]" type="image/x-icon"/>

    <title>myself - [@block name="title"][/@block]</title>
    [/@block]
    [@block name="topResources"]
    <link href="[@spring.url '/resources/css/font-awesome.min.css'/]" rel="stylesheet" type="text/css"/>
    <link href="[@spring.url '/resources/css/bootstrap.min.css'/]" rel="stylesheet" type="text/css"/>
    <link href="[@spring.url '/resources/css/templatemo-style.css'/]" rel="stylesheet" type="text/css"/>

    <script src="[@spring.url '/resources/js/html5shiv.min.js'/]" type="text/javascript"></script>
    <script src="[@spring.url '/resources/js/respond.min.js'/]" type="text/javascript"></script>
    [/@block]
<body>
<!-- Left column -->
<div class="templatemo-flex-row">
    [@block name="slider-bar"]
    [#include "/shared/left_menu.ftl" /]
    [/@block]

    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">

        <!-- top -->
        [@block name="slider-bar"]
        [#include "/shared/head.ftl" /]
        [/@block]

        <!-- content -->

        <div class="templatemo-content-container">
            <div id="content" class="tip-menu">
                <div class="pageheader">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li>当前的位置</li>
                            [@block name="position"]
                            <li>多级位置</li>
                            [/@block]
                        </ol>
                    </div>
                </div>
            </div>
            [@block name="subContent"]
            [/@block]
        </div>
    </div>

    [@block name="bottomResources"]
    <!-- JS -->
    <script src="[@spring.url '/resources/js/jquery-1.11.2.min.js'/]" type="text/javascript"></script>
    <!-- jQuery -->
    <script src="[@spring.url '/resources/js/jquery-migrate-1.2.1.min.js'/]" type="text/javascript"></script>
    <!--  jQuery Migrate Plugin -->
    <script src="[@spring.url '/resources/js/templatemo-script.js'/]" type="text/javascript"></script>
    <!-- Templatemo Script -->
    [/@block]
</body>
</head>
</html>