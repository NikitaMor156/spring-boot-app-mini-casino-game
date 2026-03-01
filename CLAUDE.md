# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run

```bash
# Run the application (starts on http://localhost:8081)
./mvnw spring-boot:run

# Run tests
./mvnw test

# Build JAR
./mvnw package
```

The current branch (`With_in-memory_database`) uses an H2 in-memory database — no external DB setup required. The commented-out lines in `application.properties` show the original MySQL configuration for the `master` branch.

## Architecture

**Layer structure:** Controller → Service → DAO → JPA EntityManager

- `SpringBootAppApplication` — entry point
- **Controllers:** `MainController` (user CRUD at `/`) and `GameController` (all game endpoints under `/play/getGamesList`)
- **Service:** `UserService` / `UserServiceImpl` — thin wrapper over the DAO
- **DAO:** `UserDAO` / `UserDAOImpl` — uses raw `EntityManager` (not Spring Data repositories)
- **Entity:** `User` (id, name, region, balance stored as int)
- **Views:** JSP files in `src/main/webapp/WEB-INF/views/`

## Game Flow

1. User selects or creates a profile on the home page
2. Selecting a user writes their ID to `HttpSession` (`currentPlayingUserId`)
3. `PlayingUserManager` (`@Component`) reads the session on every request to fetch the current user and handles balance mutations (`addAmountAndSave`, `withdrawAmountAndSave`)
4. `GameController` delegates to game manager classes for game logic

## Games

| Game | Manager class | Notes |
|---|---|---|
| Roulette | `RouletteManager` | Red (45%), Black (45%), Green (10%); bets deducted, winnings paid |
| Guess the Number | `GuessTheNumberManager` | Win pays 3× bid; loss deducts bid |
| Russian Roulette | `RussianRouletteManager` | Loss **deletes the user** from the DB |
| One Hand Bandit | `OneHandBanditManager` | 5-slot machine with `*`, `#`, `$`; multipliers based on longest sequential run |

## Known Issue

In `GameController.java`, the private helper method `updateUserBalanceAfterGuessTheNumberSpin` has a `@RequestMapping("/playSimpleRoulette")` annotation on it — this annotation is misplaced and the method is not a request handler. `SimpleRouletteManager` also exists but has no controller endpoint wired to it.
