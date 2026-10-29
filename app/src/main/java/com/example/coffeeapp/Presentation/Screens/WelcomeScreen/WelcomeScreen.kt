package com.example.coffeeapp.Presentation.Screens.WelcomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.Presentation.Navigation.Routes
import com.example.coffeeapp.R


@Composable
fun WelcomeScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize().background(color = Color.Black)
    ){
        Image(
            painter = painterResource(R.drawable.coffeeimage1),
            contentDescription = "Welcome Image"
        )

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(vertical = 60.dp , horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text("Fall In Love With Coffee \n In  Blissful Delight!",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text("Welcome to our Cozy coffee corner, where Every Cup is a Delight for You",
                fontSize = 15.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center
                )
            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = { navController.navigate(Routes.HomeScreen) },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC47B4D),
                    contentColor = Color.White
                )
            ) {
                Text("Get Started",
                    fontSize = 20.sp)
            }

        }
    }
}