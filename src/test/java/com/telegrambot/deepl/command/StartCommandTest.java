/*
- Copyright 2023 Aleksandr Shabalin
-
- Licensed under the Apache License, Version 2.0 (the "License");
- you may not use this file except in compliance with the License.
- You may obtain a copy of the License at
-
- `<http://www.apache.org/licenses/LICENSE-2.0>`
-
- Unless required by applicable law or agreed to in writing, software
- distributed under the License is distributed on an "AS IS" BASIS,
- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
- See the License for the specific language governing permissions and
- limitations under the License.
*/

package com.telegrambot.deepl.command;

import com.telegrambot.deepl.config.BotConfig;

import static com.telegrambot.deepl.command.CommandName.START;
import static com.telegrambot.deepl.command.StartCommand.START_MESSAGE;

public class StartCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return START.getCommandName();
    }
    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }
    @Override
    CommandInterface getCommand() {
        BotConfig config = null;
        return new StartCommand(sendMessageServiceInterface, userService, deeplBot);
    }
}
