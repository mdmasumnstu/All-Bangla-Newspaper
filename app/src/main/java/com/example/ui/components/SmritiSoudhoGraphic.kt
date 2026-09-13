package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.RedPrimary
import com.example.ui.theme.TextSlate600

/**
 * Clean silhouette representation of Jatiyo Smriti Soudho (National Martyrs' Memorial)
 * with the red circular sun in the background, matching Screen 1 & Screen 11.
 */
@Composable
fun SmritiSoudhoGraphic(
    tagline: String,
    subTagline: String? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Canvas(modifier = Modifier.size(width = 240.dp, height = 95.dp)) {
                val w = size.width
                val h = size.height
                val centerX = w / 2f
                val baseY = h - 6f

                // Red Sun circle (offset slightly to the left/center)
                drawCircle(
                    color = RedPrimary.copy(alpha = 0.85f),
                    radius = 28.dp.toPx(),
                    center = Offset(centerX - 18.dp.toPx(), baseY - 26.dp.toPx())
                )

                // Silhouette color (soft grey/slate)
                val memorialColor = Color(0xFFD6DBDF)
                val darkSpireColor = Color(0xFFBDC3C7)

                // 7 Pairs of triangular spires of Jatiyo Smriti Soudho
                // Outer widest spires
                val pathOuterLeft = Path().apply {
                    moveTo(centerX - 85.dp.toPx(), baseY)
                    lineTo(centerX - 24.dp.toPx(), baseY - 36.dp.toPx())
                    lineTo(centerX, baseY)
                    close()
                }
                drawPath(pathOuterLeft, memorialColor.copy(alpha = 0.6f))

                val pathOuterRight = Path().apply {
                    moveTo(centerX + 85.dp.toPx(), baseY)
                    lineTo(centerX + 24.dp.toPx(), baseY - 36.dp.toPx())
                    lineTo(centerX, baseY)
                    close()
                }
                drawPath(pathOuterRight, memorialColor.copy(alpha = 0.6f))

                // Mid spires
                val pathMidLeft = Path().apply {
                    moveTo(centerX - 60.dp.toPx(), baseY)
                    lineTo(centerX - 14.dp.toPx(), baseY - 58.dp.toPx())
                    lineTo(centerX, baseY)
                    close()
                }
                drawPath(pathMidLeft, memorialColor.copy(alpha = 0.75f))

                val pathMidRight = Path().apply {
                    moveTo(centerX + 60.dp.toPx(), baseY)
                    lineTo(centerX + 14.dp.toPx(), baseY - 58.dp.toPx())
                    lineTo(centerX, baseY)
                    close()
                }
                drawPath(pathMidRight, memorialColor.copy(alpha = 0.75f))

                // Inner tall center spires
                val pathCenterLeft = Path().apply {
                    moveTo(centerX - 35.dp.toPx(), baseY)
                    lineTo(centerX - 3.dp.toPx(), baseY - 84.dp.toPx())
                    lineTo(centerX, baseY)
                    close()
                }
                drawPath(pathCenterLeft, darkSpireColor)

                val pathCenterRight = Path().apply {
                    moveTo(centerX + 35.dp.toPx(), baseY)
                    lineTo(centerX + 3.dp.toPx(), baseY - 84.dp.toPx())
                    lineTo(centerX, baseY)
                    close()
                }
                drawPath(pathCenterRight, memorialColor)

                // Sharp highest spire
                val topSpire = Path().apply {
                    moveTo(centerX - 6.dp.toPx(), baseY)
                    lineTo(centerX, baseY - 92.dp.toPx())
                    lineTo(centerX + 6.dp.toPx(), baseY)
                    close()
                }
                drawPath(topSpire, Color(0xFF95A5A6))

                // Base ground line
                drawLine(
                    color = Color(0xFFE2E8F0),
                    start = Offset(0f, baseY),
                    end = Offset(w, baseY),
                    strokeWidth = 2.dp.toPx()
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = tagline,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp
            ),
            color = TextSlate600,
            textAlign = TextAlign.Center
        )

        if (subTagline != null) {
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subTagline,
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 11.5.sp
                ),
                color = TextSlate600.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
        }
    }
}
