package kr.ac.kumoh.ce.s20220736.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import kr.ac.kumoh.ce.s20220736.intent.ui.theme.IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        IntentButtons(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun IntentButtons(modifier : Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
    ) {
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("https://www.youtube.com/results?search_query=android+developers")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)   // 교안과 다른 부분.
            }
        ) {
            Text("유튜브")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("https://www.github.com/Nem-nooy")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)   // 교안과 다른 부분.
            }
        ) {
            Text("깃허브")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("geo:36.145014,128.393047?z=17")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)   // 교안과 다른 부분.
            }
        ) {
            Text("좌표")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("geo:0, 0?q=금오공과대학교")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)   // 교안과 다른 부분.
            }
        ) {
            Text("주소")
        }

//        Button(
//            modifier = modifier.fillMaxWidth(),
//            onClick = {
//                val uri = Uri.parse("tel:01011112222")
//                val intent = Intent(Intent.ACTION_VIEW, uri)
//                context.startActivity(intent)   // 교안과 다른 부분.
//            }
//        ) {
//            Text("전화")
//        }
//
//        Button(
//            modifier = modifier.fillMaxWidth(),
//            onClick = {
//                val uri = Uri.parse("sms:01011112222")
//                val intent = Intent(Intent.ACTION_VIEW, uri)
//                intent.putExtra("sms_body", "전화 부탁드립니다.")
//                context.startActivity(intent)   // 교안과 다른 부분.
//            }
//        ) {
//            Text("문자")
//        }

        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, SecondActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Text("Activity")
        }
    }
}