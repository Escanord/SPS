// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!', 'Xin chào'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

/**
 * Adds a random quote to the page.
 */
function addRandomQuote() {
    const quotes =
        ['For Vietnam, Cuba is willing to devote its blood',
         '... Cuba slept when Vietnam was awake to guard Cuba’s sleep and vice versa...',
         'Brothers'];
  
    // Pick a random quote.
    const quote = quotes[Math.floor(Math.random() * quotes.length)];
  
    // Add it to the page.
    const quoteContainer = document.getElementById('quote-container');
    quoteContainer.innerText = quote;
  }

/**
 * Adds a random lyric of Always remember us this way to the page
 */
async function addLyric() {
    const responseFromServer = await fetch('/lyric')
    const lyric = await responseFromServer.json()
    const lyricContainer = document.getElementById('lyric-container')
    lyricContainer.innerText = lyric[Math.floor(Math.random() * lyric.length)]
}