package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.repository.StudyRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("NTR Vision AI", appName)
  }

  @Test
  fun `verify all maharashtra ssc chapters loaded`() {
    val allChapters = StudyRepository.getAllChapters()
    // Science 1 (10) + Science 2 (10) + Math 1 (6) + Math 2 (7) = 33 chapters
    assertEquals(33, allChapters.size)
    assertTrue(allChapters.any { it.title.contains("Gravitation") })
    assertTrue(allChapters.any { it.title.contains("Similarity") })
    assertTrue(allChapters.any { it.title.contains("Linear Equations") })
    assertTrue(allChapters.any { it.title.contains("Heredity") })
  }
}

