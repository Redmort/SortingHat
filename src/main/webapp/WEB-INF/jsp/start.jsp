
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../../resources/static/jquery-3.2.1.min.js"></script>

    <style type="text/css">

        <%@include file="/resources/static/bootstrap.js" %>

        @keyframes spin {
            from{
                transform: rotateZ(0deg);
                moz-transform: rotateZ(0deg); //Firefox
            ms-transform: rotateZ(0deg); //Microsoft Browsers
            }
            to{
                transform: rotateZ(360deg);
                moz-transform: rotateZ(360deg); //Firefox
            ms-transform: rotateZ(360deg); //Microsoft Browsers
            }
        }
        @-webkit-keyframes spin{
            from{-webkit-transform: rotateZ(0deg);}
            to{-webkit-transform: rotateZ(360deg);}
        }
        .imageSpin{
            animation-name: spin;
            animation-timing-function: linear;
            animation-iteration-count: infinite;
            animation-duration: 1s;
            -webkit-animation-name: spin;
            -webkit-animation-timing-function: linear;
            -webkit-animation-iteration-count: infinite;
            -webkit-animation-duration: 1s;
        }

        .imageSpin1{
            animation-name: spin;
            animation-timing-function: linear;
            animation-iteration-count: infinite;
            animation-duration: 0.7s;
            -webkit-animation-name: spin;
            -webkit-animation-timing-function: linear;
            -webkit-animation-iteration-count: infinite;
            -webkit-animation-duration: 0.7s;
        }

        .imageSpin2{
            animation-name: spin;
            animation-timing-function: linear;
            animation-iteration-count: infinite;
            animation-duration: 0.5s;
            -webkit-animation-name: spin;
            -webkit-animation-timing-function: linear;
            -webkit-animation-iteration-count: infinite;
            -webkit-animation-duration: 0.5s;
        }

        .imageSpin3{
            animation-name: spin;
            animation-timing-function: linear;
            animation-iteration-count: infinite;
            animation-duration: 0.2s;
            -webkit-animation-name: spin;
            -webkit-animation-timing-function: linear;
            -webkit-animation-iteration-count: infinite;
            -webkit-animation-duration: 0.2s;
        }


        .img-holder {position: relative;}
        .img-holder .link {
        position: absolute;
        bottom: 302px;
        right: 284px;
        color: blue;
        }

        .img-holder {position: relative;}
        .img-holder .link1 {
            position: absolute;
            bottom: 302px;
            right: 284px;
            color: blue;
        }

        .img-holder .link2 {
            position: absolute;
            bottom: 160px;
            right: 150px;
            color: blue;
        }

        .imgBanner1{

        }


    </style>

    <script type="text/javascript" language="javascript">

        var picPaths = ['/resources/img/circlePurpleLight.png','/resources/img/circle5.png','/resources/img/circleOrange.png','/resources/img/circleGreen.png'];
        var curPic = -1;
        //preload the images for smooth animation
        var imgO = new Array();
        for(i=0; i < picPaths.length; i++) {
            imgO[i] = new Image();
            imgO[i].src = picPaths[i];
        }

        window.onload = function() {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    var resp = this.responseText;
                    $('.IsBestAnswer').addClass('imageSpin').removeClass('IsBestAnswer');
                    $('.imgBanner1').addClass('imgBanner').removeClass('imgBanner1');
                    $('.imgBanner6').hide();
                    imgCont = document.getElementsByClassName('imgBanner').item(0);
                    swapImage();
                    var millisecondsToWait = 1000;
                    setTimeout(function() {
                        $('.imageSpin').addClass('imageSpin2').removeClass('imageSpin');
                        millisecondsToWait = 2000;
                        setTimeout(function() {
                            $('.imageSpin2').addClass('imageSpin3').removeClass('imageSpin2');

                            millisecondsToWait = 3000;
                            setTimeout(function() {
                                $('.imageSpin3').addClass('imageSpin2').removeClass('imageSpin3');

                                millisecondsToWait = 2000;
                                setTimeout(function() {
                                    $('.imageSpin2').addClass('imageSpin1').removeClass('imageSpin2');

                                    millisecondsToWait = 1000;
                                    setTimeout(function() {
                                        $('.imageSpin1').addClass('IsBestAnswer').removeClass('imageSpin1');

                                        $('.imgBanner').hide();

                                        if (resp === "1"){
                                            $('.imgBanner2').show();
                                            $('.imgBanner12').show();
                                        }else if (resp === "2"){
                                            $('.imgBanner3').show();
                                            $('.imgBanner13').show();
                                        }else if (resp === "3"){
                                            $('.imgBanner4').show();
                                            $('.imgBanner14').show();
                                        }else if (resp === "4"){
                                            $('.imgBanner5').show();
                                            $('.imgBanner15').show();
                                        }else {
                                            $('.imgBanner16').show();
                                            $('.imgBanner6').show();
                                        }

                                        millisecondsToWait = 10000;
                                        setTimeout(function() {
                                            var reset = UserAction();

                                        }, millisecondsToWait);

                                    }, millisecondsToWait);
                                }, millisecondsToWait);
                            }, millisecondsToWait);
                        }, millisecondsToWait);
                    }, millisecondsToWait);
                }
            };
            xhttp.open("POST", "/addMinutes.html", true);
            xhttp.setRequestHeader("Content-type", "application/json");
            xhttp.send();
        }

        function swapImage() {
            curPic = (++curPic > picPaths.length-1)? 0 : curPic;
            imgCont.src = imgO[curPic].src;
            setTimeout(swapImage,90);
        }

        function UserAction() {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    location.reload();
                }
            };
            xhttp.open("POST", "/reset.html", true);
            xhttp.setRequestHeader("Content-type", "application/json");
            xhttp.send();
        }


    </script>

    <title>Title</title>
</head>
<body>

<%--<b><%= request.getAttribute("firstName") %></b> <b><%= request.getAttribute("family") %></b>--%>
<%--<div class="container body-content span=8 offset=2">--%>
<div class="img-holder" align="center">
<img class="School" style="width:auto" style="height: 500px"  id="p2" src="${pageContext.request.contextPath}/resources/img/SchoolnoO2.png"/>
    <div class="link">

        <img class="IsBestAnswer" id="p3" style="width:450px" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/brakettePurple.png"/>
    </div>
        <div class="link1">
                <img class="imgBanner1" style="width:450px" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/circleyellow.png"/>
            <img class="imgBanner2" hidden="hidden" style="width:450px" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/circlePurpleLight.png"/>
            <img class="imgBanner3" hidden="hidden" style="width:450px" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/circleGreen.png"/>
            <img class="imgBanner4" hidden="hidden" style="width:450px" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/circleOrange.png"/>
            <img class="imgBanner5" hidden="hidden" style="width:450px" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/circle5.png"/>
            <img class="imgBanner16" hidden="hidden" style="width:450px" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/circleyellow.png"/>
        </div>
    <div class="link2">
        <img class="imgBanner6" style="width:auto" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/SchooWordl.png"/>
        <img class="imgBanner12" hidden="hidden" style="width:auto" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/diplomatiWord2.png"/>
        <img class="imgBanner13" hidden="hidden" style="width:auto" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/harmoniWord2.png"/>
        <img class="imgBanner14" hidden="hidden" style="width:auto" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/intelektiWord2.png"/>
        <img class="imgBanner15" hidden="hidden" style="width:auto" style ="height:auto" src="${pageContext.request.contextPath}/resources/img/idealiWord2.png"/>
    </div>

</div>
<%--</div>--%>


</body>
</html>
