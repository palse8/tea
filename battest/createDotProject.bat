echo off
set pjname=%1
set pjname2=%2
echo 置換開始
chcp 65001
setlocal enabledelayedexpansion
for /f "delims=" %%A in (projectTemplate.txt) do (
    set line0=%%A
    set line1=!line0:{pjname}=%pjname%!
    set line2=!line1:{pjname2}=%pjname2%!
    echo !line2!>>output\.project
)
endlocal
chcp 932
echo 置換完了