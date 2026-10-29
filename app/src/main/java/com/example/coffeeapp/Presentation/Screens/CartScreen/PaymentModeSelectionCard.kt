package com.example.coffeeapp.Presentation.Screens.CartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.R


@Composable
fun PaymentModeSelectionCard(totalAmount: Double) {

    var expanded by remember { mutableStateOf(false) }
    var selectedMode by remember { mutableStateOf("Online") }


    val paymentmodes = listOf("Online", "Cash")

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        painter = painterResource(if (selectedMode == "Online") R.drawable.mobile_banking else R.drawable.wallet),
                        contentDescription = "Mobile Banking",
                        modifier = Modifier.size(30.dp),
                        tint = LightBrown
                    )

                    Spacer(modifier = Modifier.width(8.dp))


                    Column() {
                        Text(
                            text = selectedMode, style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold, color = Color.Black
                            )
                        )

                        Text(
                            text = "$ $totalAmount",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = LightBrown
                            )
                        )
                    }

                }
                Box {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_arrow_down),
                        contentDescription = "Arrow Down",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { expanded = !expanded })

                    DropdownMenu(
                        expanded = expanded, onDismissRequest = { expanded = false }) {
                        paymentmodes.forEach { mode ->
                            DropdownMenuItem(
                                text = {
                                Text(
                                    text = mode, style = MaterialTheme.typography.bodyLarge
                                )
                            }, onClick = {
                                selectedMode = mode;
                                expanded = false
                            }, leadingIcon = {
                                Icon(
                                    painter = painterResource(
                                        if (mode == "Online") R.drawable.mobile_banking else R.drawable.wallet
                                    ),
                                    contentDescription = null,
                                    tint = LightBrown,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .background(
                                        color = if (selectedMode == mode) LightBrown.copy(0.4f)
                                        else Color.Transparent
                                    )
                            )
                        }
                    }
                }


            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC47B4D), contentColor = Color.White
                )
            ) {
                Text(
                    "Place Order", fontSize = 18.sp
                )
            }
        }
    }

}