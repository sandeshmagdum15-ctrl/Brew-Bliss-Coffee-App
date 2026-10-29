package com.example.coffeeapp.Presentation.Screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.Domain.Model.Product
import com.example.coffeeapp.Presentation.Navigation.Routes
import com.example.coffeeapp.R
import com.example.coffeeapp.Presentation.theme.IvoryWhite
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.LightGray
import kotlinx.serialization.descriptors.PrimitiveKind

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = {navController.navigate(Routes.DetailScreen(product.id))}),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                Image(
                    painter = painterResource(product.imageRes),
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(24.dp))
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(
                            color = LightGray.copy(0.7f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_heart),
                        contentDescription = "add to favourite",
                        tint = LightBrown,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.name, style = typography.titleMedium.copy(
                    color = Color.Black, fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.description, style = typography.bodySmall.copy(
                    color = Color.Gray

                ), maxLines = 1, overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${product.price}", style = typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold, color = LightBrown
                    )
                )
                IconButton(
                    onClick = {}, modifier = Modifier.background(
                        color = LightBrown, shape = RoundedCornerShape(10.dp)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to cart",
                        tint = IvoryWhite
                    )
                }

            }

        }
    }
}