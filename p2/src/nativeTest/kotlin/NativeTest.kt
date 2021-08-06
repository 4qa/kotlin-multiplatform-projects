import curl.*
import kotlinx.cinterop.toKString
import kotlin.test.Test

@OptIn(ExperimentalUnsignedTypes::class)
class NativeTest {
    @Test
    fun curlShared() {
        val curl = curl_easy_init()
        if (curl != null) {
            curl_easy_setopt(curl, CURLOPT_URL, "http://example.com")
            curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L)
            val res = curl_easy_perform(curl)
            if (res != CURLE_OK) {
                println("curl_easy_perform() failed ${curl_easy_strerror(res)?.toKString()}")
            }
            curl_easy_cleanup(curl)
        }
    }
}

