            if (choice == 1) {
                int value;
                while (true) {
                    try {
                        System.out.println("Choose the target: ");
                        value = Integer.parseInt(sc.next());
                        if (mafiaController.checkInput(value))
                            break;
                        else
                            System.out.println("Mafia can't be chosen Target");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. \nPlease Try Again.");

                    }
                }
                mafiaChoice = value;
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                detectiveChoice = detectiveController.getRandom("Detectives have chosen a player to test.");
                healerChoice = healerController.getRandomAll("Healers have chosen someone to heal.", players);
                //Healing process
                int hp = players.get(healerChoice).getHp();
                players.get(healerChoice).setHp(hp + 500);

                System.out.println("--End of actions--");
                //Target returns -1 if player hp > combined mafia hp
                if (target == -1 || players.get(target) == players.get(healerChoice)) {
                    System.out.println("No one died.");

                } else {
                    System.out.println("Player" + target + " has died.");
                    removeValues(target);
                    if (!checkUserAlive(target))
                        choice = 0;
                }
                //vote
                //test if player is mafia
                if (!mafiaController.checkInput(detectiveChoice)) {
                    System.out.println("Player" + detectiveChoice + " has been voted out.");
                    removeValues(detectiveChoice);
                    if (!checkUserAlive(detectiveChoice))
                        choice = 0;
                } else {
                    int voteOut = healerController.getRandomAll("", players);
                    System.out.println("Player" + voteOut + " has been voted out.");
                    removeValues(voteOut);
                    if (!checkUserAlive(voteOut))
                        choice = 0;
                }
            }