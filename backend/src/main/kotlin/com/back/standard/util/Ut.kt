package com.back.standard.util

import java.net.HttpURLConnection
import java.net.URI
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

        fun finalUrl(urlStr: String): String {
            val uri = URI(urlStr)
            val connection = uri.toURL().openConnection() as HttpURLConnection

            return try {
                connection.instanceFollowRedirects = true
                connection.responseCode // 이게 있어야 실제 최종 url까지 redirect 됨

                connection.url.toString()
            } finally {
                connection.disconnect()
            }
        }

        fun headers(urlStr: String): Map<String, *> {
            val uri = URI(urlStr)
            val connection = uri.toURL().openConnection() as HttpURLConnection

            return try {
                connection.instanceFollowRedirects = true
                connection.responseCode // 이게 있어야 실제 최종 url까지 redirect 됨

                connection.headerFields
                    .mapValues { (_, v) ->
                        if (v.size == 1) v[0] else v
                    }
            } finally {
                connection.disconnect()
            }
        }
    }
}