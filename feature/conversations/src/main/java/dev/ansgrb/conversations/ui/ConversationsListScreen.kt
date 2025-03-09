/*
 * Product Made by Anas Ghareib
 * Copyright (C) 2025 Anas Ghareib
 *
 * All rights reserved. This software and associated documentation files
 * (the "Software") are proprietary and confidential. Unauthorized copying,
 * distribution, modification, or use of this Software, via any medium,
 * is strictly prohibited without prior written permission from Anas Ghareib.
 *
 * This Software is provided "as is", without warranty of any kind, express
 * or implied, including but not limited to the warranties of merchantability,
 * fitness for a particular purpose, and non-infringement. In no event shall
 * the author be liable for any claim, damages, or other liability,
 * whether in an action of contract, tort, or otherwise, arising from,
 * out of, or in connection with the Software or the use of it.
 */
package dev.ansgrb.conversations.ui

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.ansgrb.conversations.R
import dev.ansgrb.conversations.ui.model.Conversation

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ConversationsListScreen(
    onNewConversationClick: () -> Unit,
    onConversationClick: (chatId: String) -> Unit
) {
    val tabs = generateTabs()
    val selectedTabIndex = remember { mutableStateOf(1) }
    val pageState = rememberPagerState(
        initialPage = 1,
        initialPageOffsetFraction = TODO(),
        pageCount = TODO()
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.conversations_list_title)) },
                actions = {
                    IconButton(onClick = onNewConversationClick) {
                        Icon(Icons.Rounded.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        bottomBar = {
            TabRow(selectedTabIndex = 1) {
                tabs.forEachIndexed {index, tab ->
                    Tab(
                        text = { Text(stringResource(tabs[index].title)) },
                        selected = index == 1,
                        onClick = { /* Handle tab selection */ }
                    )

                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onNewConversationClick() }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },
        content = { innerPadding ->
            HorizontalPager(
                modifier = Modifier.padding(innerPadding),
//                pageCount = tabs.size,
                state = pageState
            ) { index ->
                when (index) {
                    0 -> {
                        // TODO: Add Status Screen
                    }
                    1 -> {
                        ConversationList(
                            conversations = generateFakeConversations(),
                            onConversationClick = onConversationClick
                        )
                    }
                    2 -> {
                        // TODO: Add Calls Screen
                    }
                }
            }
        }
    )
}

// Data class for the tabs :) cuz why not
data class ConversationsListTab(
    @StringRes val title: Int,
)

fun generateTabs(): List<ConversationsListTab> {
    return listOf(
        ConversationsListTab(
            title = R.string.conversations_tab_status_title,
        ),
        ConversationsListTab(
            title = R.string.conversations_tab_chats_title,
        ),
        ConversationsListTab(
            title = R.string.conversations_tab_calls_title,
        ),
    )
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Conversations List Screen"
)
@Composable
private fun ConversationsListScreenPreview() {
    ConversationsListScreen({}, {})
}

fun generateFakeConversations(): List<Conversation> {
    return listOf(
        Conversation(
            id = "1",
            name = "John Doe",
            message = "Hey, how are you?",
            timestamp = "10:30",
            avatar = "https://i.pravatar.cc/150?u=1",
            unreadCount = 2
        ),
        Conversation(
            id = "2",
            name = "Jane Smith",
            message = "Looking forward to the party!",
            timestamp = "11:15",
            avatar = "https://i.pravatar.cc/150?u=2"
        ),
        // Add more conversations here
        Conversation(
            id = "3",
            name = "Michael Johnson",
            message = "Did you finish the project?",
            timestamp = "9:45",
            avatar = "https://i.pravatar.cc/150?u=3",
            unreadCount = 3
        ),
        Conversation(
            id = "4",
            name = "Emma Brown",
            message = "Great job on the presentation!",
            timestamp = "12:20",
            avatar = "https://i.pravatar.cc/150?u=4"
        ),
        Conversation(
            id = "5",
            name = "Lucas Smith",
            message = "See you at the game later.",
            timestamp = "14:10",
            avatar = "https://i.pravatar.cc/150?u=5",
            unreadCount = 1
        ),
        Conversation(
            id = "6",
            name = "Sophia Johnson",
            message = "Let's meet for lunch tomorrow.",
            timestamp = "16:00",
            avatar = "https://i.pravatar.cc/150?u=6"
        ),
        Conversation(
            id = "7",
            name = "Olivia Brown",
            message = "Can you help me with the assignment?",
            timestamp = "18:30",
            avatar = "https://i.pravatar.cc/150?u=7",
            unreadCount = 5
        ),
        Conversation(
            id = "8",
            name = "Liam Williams",
            message = "I'll call you later.",
            timestamp = "19:15",
            avatar = "https://i.pravatar.cc/150?u=8"
        ),
        Conversation(
            id = "9",
            name = "Charlotte Johnson",
            message = "Don't forget the meeting tomorrow.",
            timestamp = "21:45",
            avatar = "https://i.pravatar.cc/150?u=9",
            unreadCount = 1
        ),
        Conversation(
            id = "10",
            name = "James Brown",
            message = "The movie was awesome!",
            timestamp = "23:00",
            avatar = "https://i.pravatar.cc/150?u=10"
        ),
        Conversation(
            id = "11",
            name = "Jake Smith",
            message = "Did you get the tickets?",
            timestamp = "23:50",
            avatar = "https://i.pravatar.cc/150?u=11"
        )
    )
}