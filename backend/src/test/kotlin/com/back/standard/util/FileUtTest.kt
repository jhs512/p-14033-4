package com.back.standard.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FileUtTest {
    @Test
    @DisplayName("파일을 생성하고 삭제할 수 있다.")
    fun t1() {
        Ut.file.touch("test.txt")
        Ut.file.delete("test.txt")
    }

    @Test
    @DisplayName("finalUrl : https://picsum.photos/id/237/200/300 -> https://fastly.picsum.photos/id/237/200/300.jpg?hmac=...")
    fun t2() {
        val finalUrl = Ut.file.finalUrl("https://picsum.photos/id/237/200/300")

        assertThat(finalUrl).startsWith("https://fastly.picsum.photos/id/237/200/300.jpg?hmac=")
    }

    @Test
    @DisplayName("headers")
    fun t3() {
        val headers = Ut.file.headers("https://picsum.photos/id/237/200/300")

        assertThat(headers["Content-Type"]).isEqualTo("image/jpeg")
        assertThat(headers["Content-Disposition"]).isEqualTo("inline; filename=\"237-200x300.jpg\"")
    }
}