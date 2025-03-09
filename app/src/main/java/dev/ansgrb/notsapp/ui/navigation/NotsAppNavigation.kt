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
package dev.ansgrb.notsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.ansgrb.conversations.ui.ConversationsListScreen
import dev.ansgrb.framework.navigation.NavRoutes


@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost (
        navController,
        startDestination = NavRoutes.ConversationsList
    ) {
        addConversationsList(navController)
        addNewConversation(navController)
        addChat(navController)
    }
}

private fun NavGraphBuilder.addConversationsList(navController: NavHostController) {
    composable(NavRoutes.ConversationsList) {
        ConversationsListScreen(
            onNewConversationClick = {
                navController.navigate(
                    NavRoutes.NewConversation
                )
            },
            onConversationClick = { chatId ->
                navController.navigate(
                    NavRoutes.Chat.replace("{chatId}", chatId)
                )
            }
        )
    }
}

private fun NavGraphBuilder.addNewConversation(navController: NavHostController) {
    // TODO: Add NewConversationScreen
}

private fun NavGraphBuilder.addChat(navController: NavHostController) {
    // TODO: Add ChatScreen
}