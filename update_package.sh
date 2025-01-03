#!/bin/bash

# 기존 및 새 패키지 이름 정의
OLD_PACKAGE="com.example.oldname"
NEW_PACKAGE="com.example.newname"

# 프로젝트 루트 디렉토리
PROJECT_DIR="/path/to/your/project"

# 1. 폴더 이름 변경
find "$PROJECT_DIR" -type d -path "*/src/main/java/com/example/oldname*" -exec bash -c '
    OLD_PATH="{}"
    NEW_PATH=$(echo "$OLD_PATH" | sed "s|com/example/oldname|com/example/newname|g")
    mv "$OLD_PATH" "$NEW_PATH"
' \;

# 2. 파일 내용 변경
grep -rl "$OLD_PACKAGE" "$PROJECT_DIR" | xargs sed -i "" "s|$OLD_PACKAGE|$NEW_PACKAGE|g"

echo "패키지 이름 및 폴더 구조 변경 완료!"
