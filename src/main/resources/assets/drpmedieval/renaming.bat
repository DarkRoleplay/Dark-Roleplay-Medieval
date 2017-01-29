@echo off
setlocal enableDelayedExpansion

pushd C:\Users\Lukas\Desktop\Minecraft Dev Envs\Dark-Roleplay-Medieval\src\main\resources\assets\drpmedieval\textures\blocks\barrels

for %%f in (*) do (
   set "filename=%%~f"

   for %%A in (a b c d e f g h i j k L m n o p q r s t u v w x y z) do (
      set "filename=!filename:%%A=_%%A!"
   )
   for %%A in (_) do (
      set "filename=!filename:%%A=!"
   )

    ren "%%f" "!filename!" >nul 2>&1
)
endlocal