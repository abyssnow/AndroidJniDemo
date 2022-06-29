#! /bin/zsh
NDK_PATH=${HOME}/Library/Android/sdk/ndk/21.4.7075529

rm -rf first/libs first/obj
rm -rf second/libs second/obj second/jni/libs
rm -rf third/libs third/obj

${NDK_PATH}/ndk-build -C first/jni

cp -r first/libs second/jni/
${NDK_PATH}/ndk-build -C second/jni

${NDK_PATH}/ndk-build -C third/jni

echo "Done!"
