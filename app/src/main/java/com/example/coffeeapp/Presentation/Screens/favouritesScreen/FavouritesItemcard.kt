package com.example.coffeeapp.Presentation.Screens.favouritesScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeapp.Domain.Model.Product
import com.example.coffeeapp.Presentation.theme.LightBrown
import com.example.coffeeapp.Presentation.theme.LightGray
import com.example.coffeeapp.R



@Composable
fun FavouritesItemCard(product: Product, onRemove: () -> Unit) {

    var quantity by remember { mutableStateOf(1) }

    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(product.imageRes),
                contentDescription = "Coffee Image",
                modifier = Modifier
                    .size(70.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {

                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.DarkGray

                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                IconButton(
                    onClick = onRemove ,
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(0.1f),
                            shape = CircleShape
                        )
                        .size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = MaterialTheme.colorScheme.error
                    )
                }

            }
        }

    }

}