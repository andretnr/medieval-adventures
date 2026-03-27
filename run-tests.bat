@echo off
echo ============================================
echo   MEDIEVAL ADVENTURES - Executando Testes
echo ============================================
cd /d %~dp0
call mvn clean test
echo.
echo ============================================
echo   Fim da execucao dos testes
echo ============================================
pause
