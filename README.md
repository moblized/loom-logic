# Loom Logic

A calm deduction puzzle built for bottom-up thinkers.

Every row of cloth is woven from the row above it by a hidden rule. Each cell looks at the three cells above it (up-left, straight up, up-right) and the rule says whether that pattern makes a filled or an empty cell. You never see the rule. You see a few clue cells, and you work up from those small pieces to the rule that made the whole cloth.

## How to play

Open `index.html` in any browser. There is nothing to install and no build step.

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
