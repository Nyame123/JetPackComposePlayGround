
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bismark.core.ui.FollowButton
import com.bismark.core.ui.theme.JPGTheme
import com.bismark.feature.interests.R

@Composable
fun InterestsItem(
    name: String,
    following: Boolean,
    topicImageUrl: String,
    onClick: () -> Unit,
    onFollowButtonClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    description: String = "",
    itemSeparation: Dp = 16.dp
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
                .clickable { onClick() }
                .padding(vertical = itemSeparation)
        ) {
            InterestsIcon(topicImageUrl, iconModifier.size(64.dp))
            Spacer(modifier = Modifier.width(16.dp))
            InterestContent(name, description)
        }
        FollowButton(
            following = following,
            onFollowChange = onFollowButtonClick,
            notFollowingContentDescription = stringResource(
                id = R.string.interests_card_follow_button_content_desc
            ),
            followingContentDescription = stringResource(
                id = R.string.interests_card_unfollow_button_content_desc
            )
        )
    }
}

@Composable
private fun InterestContent(name: String, description: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(
                vertical = if (description.isEmpty()) 0.dp else 4.dp
            )
        )
        if (description.isNotEmpty()) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun InterestsIcon(topicImageUrl: String, modifier: Modifier = Modifier) {
    if (topicImageUrl.isEmpty()) {
        Icon(
            imageVector = Filled.Android,
            tint = Color.Magenta,
            contentDescription = null,
            modifier = modifier
        )
    } else {
        AsyncImage(
            model = topicImageUrl,
            contentDescription = null,
            modifier = modifier
        )
    }
}

@Preview
@Composable
private fun InterestsCardPreview() {
    JPGTheme {
        Surface {
            InterestsItem(
                name = "Compose",
                description = "Description",
                following = false,
                topicImageUrl = "",
                onClick = { },
                onFollowButtonClick = { }
            )
        }
    }
}

@Preview
@Composable
private fun InterestsCardLongNamePreview() {
    JPGTheme {
        Surface {
            InterestsItem(
                name = "This is a very very very very long name",
                description = "Description",
                following = true,
                topicImageUrl = "",
                onClick = { },
                onFollowButtonClick = { }
            )
        }
    }
}

@Preview
@Composable
private fun InterestsCardLongDescriptionPreview() {
    JPGTheme {
        Surface {
            InterestsItem(
                name = "Compose",
                description = "This is a very very very very very very very " +
                    "very very very long description",
                following = false,
                topicImageUrl = "",
                onClick = { },
                onFollowButtonClick = { }
            )
        }
    }
}

@Preview
@Composable
private fun InterestsCardWithEmptyDescriptionPreview() {
    JPGTheme {
        Surface {
            InterestsItem(
                name = "Compose",
                description = "",
                following = true,
                topicImageUrl = "",
                onClick = { },
                onFollowButtonClick = { }
            )
        }
    }
}
