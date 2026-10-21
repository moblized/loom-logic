# Loom Logic

A calm deduction puzzle built for bottom-up thinkers.

Every row of cloth is woven from the row above it by a hidden rule. Each cell looks at the three cells above it (up-left, straight up, up-right) and the rule says whether that pattern makes a filled or an empty cell. You never see the rule. You see a few clue cells, and you work up from those small pieces to the rule that made the whole cloth.

## Get it

- **Android:** download `LoomLogic.apk` from the [latest release](https://github.com/moblized/loom-logic/releases/latest) and open it on your phone. You may need to allow installs from your browser or file manager. The app runs fully offline.
- **Browser:** open `index.html` in any browser. There is nothing to install and no build step.

## How to play

1. Set the 8 entries on the rule card. Tap an entry to switch it between not set, filled and empty.
2. Some later patterns have missing top-row cells (yellow dashed outline). Tap those to set them too.
3. The cloth weaves itself from your settings. You're done when every cell is woven and every clue matches.

A solid diamond means a clue cell is filled. A hollow diamond means it is empty.

## Features

- 24 patterns in 5 sets, from clues right under the top row down to clues only at the very bottom
- Every pattern has exactly one solution, reachable by logic (checked with a built-in solver)
- Lens: tap any cell to see the three cells that made it and the rule entry used
- Mark mode for pencil notes, plus undo, redo and teaching hints
- Practice mode with fresh random patterns at any level
- No timer, no sound, no score to lose
- Settings for mismatch outlines, reduced motion, stronger cell edges and text size
- Light and dark themes follow your system; progress saves in your browser

The rules are the 256 elementary cellular automata, so a finished cloth tells you its rule number (Rule 30, Rule 110 and so on).

## Keyboard

Arrow keys move around the cloth, 1 to 8 switch rule entries, M switches Look and Mark, Z undoes, Y redoes.

## Building the Android app

The `android/` folder is a small WebView app that bundles `index.html` and `fonts/`. Every push to `main` that touches the game or the app runs the **Build Android APK** workflow, which publishes a new release with the APK attached. You can also run it by hand from the Actions tab.

Builds are signed with the key in `android/signing/`. That key is public, which is fine for installing on your own devices, and it keeps every build's signature the same so updates install over the old version without losing progress. To sign with a private key instead, add `KEYSTORE_B64` (the keystore, base64-encoded), `KEYSTORE_PASSWORD` and `KEY_ALIAS` as repository secrets. Switching keys means uninstalling the old build once.

## Fonts

Syne, Atkinson Hyperlegible and IBM Plex Mono are bundled under the SIL Open Font License; see `fonts/`.
