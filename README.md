### Players
- **[get]** /players
  - return all players
- **[get]** /players/{id}
  - player details
- **[post]** /players
  - insert new player
- **[get]** /players/{id}/loved-games
  - show player loved games
- **[put]** /players/{id}/loved-games/{gameId}
  - love game
- **[delete]** /players/{id}/loved-games/{gameId}
  - unlove game

### Games
- **[get]** /games
  - return all games
- **[get]** /games/{id}
  - game details
- **[post]** /games
  - insert new game
- **[get]** /games/top-games/{x}
  - return X top loved games