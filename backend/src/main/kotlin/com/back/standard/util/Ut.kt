package com.back.standard.util

import java.nio.file.Files
import java.nio.file.Paths

class Ut {
    object file {
        fun touch(pathStr: String) {
            val path = Paths.get(pathStr)

            // 부모 디렉토리가 없으면 생성
            path.parent?.let { parent ->
                if (!Files.exists(parent)) {
                    Files.createDirectories(parent)
                }
            }

            // 파일이 없으면 빈 파일 생성
            if (!Files.exists(path)) {
                Files.createFile(path)
            }
        }

        fun delete(pathStr: String) {
            val path = Paths.get(pathStr)

            // 파일이 존재하면 삭제
            if (Files.exists(path)) {
                Files.delete(path)
            }
        }
    }
}