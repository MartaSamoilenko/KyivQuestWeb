<html lang="en">
<head>
    <meta charset="utf-8">

    <title>Html Generated</title>


    <link href="https://fonts.googleapis.com/css?family=Montserrat&amp;display=swap" rel="stylesheet">

    <link rel="stylesheet" href="styles.css">

    <style>
        .main_background {
            overflow: hidden;
        }

        .main_background {
            background-color: rgba(253.0000001192093, 249.00000035762787, 238.00000101327896, 1);
            width: 100%;
            height: 100%;
            position: absolute;
            background-size: cover;
        }

        .login_submit_part {
            width: 255px;
            height: 25%;
            position: absolute;
            left: 2%;
            top: 290px;
        }

        .no_acc_part {
            width: 240px;
            height: 18px;
            position: absolute;
            left: 7px;
            top: 65px;
        }

        .no_acc_title {
            color: rgba(0, 0, 0, 1);
            width: 100%;
            position: absolute;
            font-family: Montserrat;
            text-align: center;
            font-size: 14px;
            letter-spacing: 0;
        }

        .sign_up_button {
            background-color: rgba(196.00000351667404, 196.00000351667404, 196.00000351667404, 0);
            width: 100%;
            height: 100%;
            position: absolute;
        }

        .login_part {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 75%;
            top: 20%;
        }

        .login_button {
            background-image: linear-gradient(
                    0deg, rgba(34.00000177323818, 124.00000020861626, 158.00000578165054, 1) 0%, rgba(33.99999797344208, 123.99997740983963, 158.00000578165054, 0.6399999856948853) 100%);
            width: 100%;
            height: 25%;
            position: absolute;
            border-top-left-radius: 33px;
            border-top-right-radius: 33px;
            border-bottom-left-radius: 33px;
            border-bottom-right-radius: 33px;
            border: 0px;

            font-family: Montserrat;
            text-align: center;
            font-size: 24px;
            letter-spacing: 0;
            color: rgba(255, 255, 255, 1);

            cursor: pointer;
        }

        .login_data_part {
            width: 100%;
            height: 20%;
            position: absolute;
            top: 13%;
        }

        .pass_part {
            width: 100%;
            height: 50%;
            position: absolute;
            top: 60%;
        }

        .pass_input {
            background-color: rgba(236.93750202655792, 232.4620109796524, 220.15442579984665, 1);
            width: 20%;
            height: 50%;
            position: absolute;
            top: 55%;
        }

        .pass_title {
            color: rgba(0, 0, 0, 1);
            position: absolute;
            font-family: Montserrat;
            text-align: left;
            font-size: 24px;
            letter-spacing: 0;
        }

        .email_part {
            width: 100%;
            height: 50%;
            position: absolute;
        }

        .email_input {
            background-color: rgba(236.93750202655792, 232.4620109796524, 220.15442579984665, 1);
            width: 20%;
            height: 50%;
            position: absolute;
            top: 55%;
        }

        .email_title {
            color: rgba(0, 0, 0, 1);
            position: absolute;
            font-family: Montserrat;
            text-align: left;
            font-size: 24px;
            letter-spacing: 0;
        }

        .welcome_title {
            olor: rgba(0, 0, 0, 1);
            position: absolute;
            left: 2%;
            font-family: Montserrat;
            text-align: center;
            font-size: 48px;
            letter-spacing: 0;
        }

        .photo_background {
            background-image: url("/images/image_1.png");
            width: 70%;
            height: 100%;
            position: absolute;
            left: 0%;
            top: 0%;
            background-repeat: no-repeat;
            background-size: cover;

        }

        .main_title {
            width: 100%;
            height: 100%;
            position: absolute;
            left: -15%;
            top: 30%;
            text-align: center;
        }

        .kyiv_quest_title {
            color: rgba(253.0000001192093, 249.00000035762787, 238.00000101327896, 1);
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0%;
            top: 0%;
            font-family: Montserrat;
            text-align: center;
            font-size: 96px;
            letter-spacing: 0;
        }

        .kyiv_quest_title2 {
            color: rgba(253.0000001192093, 249.00000035762787, 238.00000101327896, 1);
            width: 100%;
            height: 100%;
            position: absolute;
            top: 15%;
            left: 0%;
            font-family: Montserrat;
            text-align: center;
            font-size: 30px;
            letter-spacing: 0;
        }

        body {
            background: #E5E5E5;
        }
    </style>

</head>

<body style="margin: 0%" data-new-gr-c-s-check-loaded="14.1038.0" data-gr-ext-installed="">
<form action="/loginOfUser" method="post" enctype="multipart/form-data">
    <div class="main_background">
        <div class="photo_background"></div>
        <div class="main_title">
            <span class="kyiv_quest_title">KyivQuest</span>
            <span class="kyiv_quest_title2">quest on the history of Kiev</span>
        </div>
        <div class="login_part">
            <span class="welcome_title">Welcome!</span>
            <div class="login_data_part">
                <div class="email_part">
                    <input type="text" class="email_input" name="email">
                    <span class="email_title">Email</span>
                </div>
                <div class="pass_part">
                    <input type="password" class="pass_input" name="password">
                    <span class="pass_title">Password</span>
                </div>
            </div>

            <div class="login_submit_part">
                <input type="submit" class="login_button" value="Log in"/>
                <div class="no_acc_part">
                    <a href="/registrationOfUser" class="sign_up_button">
                        <span class="no_acc_title">Don’t have account yet? Sign Up</span>
                    </a>

                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
