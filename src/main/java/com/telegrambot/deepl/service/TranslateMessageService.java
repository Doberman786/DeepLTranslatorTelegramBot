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

package com.telegrambot.deepl.service;

import com.deepl.api.*;
import com.telegrambot.deepl.bot.DeepLTelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TranslateMessageService implements TranslateMessageServiceInterface {

    private static final String authKey = "<YOUR_AUTH_KEY>"; // Put your DEEPL_AUTH_KEY here

    Translator translator;

    @Override
    public TextResult translateMessageWithSourceLanguage(String message, String sourceLanguage, String targetLanguage) {
        translator = new Translator(authKey);

        TextResult result = null;
        try {
            result = translator.translateText(message, sourceLanguage, targetLanguage);
        } catch (DeepLException | InterruptedException e) {
            log.error("Error during translation process: " + e.getMessage());
        }
        return result;
    }

    @Override
    public TextResult translateAutoDetectedLanguage(String message, String targetLanguage) {
        translator = new Translator(authKey);

        TextResult result = null;
        try {
            result = translator.translateText(message, null, targetLanguage);
        } catch (DeepLException | InterruptedException e) {
            log.error("Error during translation process: " + e.getMessage());
        }
        return result;
    }
}
