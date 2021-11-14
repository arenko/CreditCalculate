package com.credit.clearscore

import com.credit.clearscore.data.Constants
import org.junit.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.Charset.defaultCharset

class ApiTest {

    @Test
    @Throws(Exception::class)
    fun testURL() {
        val connection =
            URL(Constants.BASE_URL + "endpoint.json").openConnection()
        val response = connection.getInputStream()

        val buffer = StringBuffer()
        BufferedReader(InputStreamReader(response, defaultCharset())).use { reader ->
            while (reader.readLine() != null) {
                buffer.append(reader.readLine())
            }
        }

        assert(buffer.isNotEmpty())
    }
}