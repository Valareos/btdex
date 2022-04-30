;Include Modern UI
!include "MUI2.nsh"

;Basic configuration
Name "ALTDEX"
OutFile "altdex-installer-win_x64.exe"
Unicode True
;Default installation folder
InstallDir "$PROGRAMFILES64\altdex"
;RequestExecutionLevel none
!define MUI_ABORTWARNING

;Pages
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES  


!define MUI_FINISHPAGE_RUN
!define MUI_FINISHPAGE_RUN_TEXT "Launch ALTDEX"
!define MUI_FINISHPAGE_RUN_FUNCTION "LaunchApplication"
!insertmacro MUI_PAGE_FINISH

!define MUI_FINISHPAGE_RUN_FUNCTION "LaunchApplication"

Function LaunchApplication
	Exec '"$WINDIR\explorer.exe" "$INSTDIR\altdex.exe"'
;	ExecShell "" "$INSTDIR\btdex.exe"
FunctionEnd

;Languages
;!insertmacro MUI_LANGUAGE "English"

;Installer Sections
Section "" SecExample
  SetOutPath "$INSTDIR"
  FILE ../LICENSE
  FILE ../build/launch4j/btdex.exe
  FILE /r ../dist/jdk/zulu8.54.0.21-ca-jdk8.0.292-win_x64/jre

  WriteUninstaller $INSTDIR\uninstall.exe
  
  CreateDirectory '$SMPROGRAMS\ALTDEX\'
  CreateShortCut '$SMPROGRAMS\ALTTDEX\altdex.lnk' '$INSTDIR\altdex.exe' "" '$INSTDIR\altdex.exe' 0
SectionEnd

; The uninstall section
Section "Uninstall"

Delete $INSTDIR\uninstall.exe
Delete $INSTDIR\altdex.exe
RMDir /R $INSTDIR\jre
;RMDir /R $INSTDIR

SectionEnd

