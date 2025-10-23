package com.github.nico.kata.tondeuse.adapters.input.main.validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileContentValidator {

    private final FileContentError _error = new FileContentError() ;

    private static final Pattern FIELD_COORDS = Pattern.compile("^\\d+ \\d+$");
    private static final Pattern FIELD_POS    = Pattern.compile("^\\d+ \\d+ [NEWS]$");
    private static final Pattern FIELD_CMDS   = Pattern.compile("^[GAD]+$");

    public boolean validate(final String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));

            if (scanner.hasNext()) {
                int numberOfLines = 0;

                String line = scanner.nextLine();
                numberOfLines++;

                isValideCoordateLigne(numberOfLines, line);
                

                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    numberOfLines++;

                    isValideLawnmowerPositionLigne(numberOfLines, line);

                    if (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        numberOfLines++;

                        isValideCommandLigne(numberOfLines, line);
                    } else {
                        _error.addError(numberOfLines,"Devrait avoir une liste de commande pour piloter la tondeuse");
                    }
                }
            if (0 != (numberOfLines+1)%2 || numberOfLines == 1) {
                _error.addError(numberOfLines,"Fichier trunker ou manque la définition des tondeuses");
            }

            } else {
                _error.addError(0, "Fichier vide.");
            }

            if (_error.hasError()) {
                throw _error;
            }

            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void isValideLawnmowerPositionLigne(final int numberLine, final String line) {
        if (!FIELD_POS.matcher(line).matches()) {
            _error.addError(numberLine,"les coordonnées ou l'orientation n'est pas valide, le format attendu est : X X O, où X est un chiffre / nombre, et O doit etre l'une des orientations : N,E,S ou W");
        }
    }

    private void isValideCommandLigne(final int numberLine, final String line) {
        if (!FIELD_CMDS.matcher(line).matches()) {
            _error.addError(numberLine,"L'une des commandes n'est pas : G, A ou D");
        }
    }

    private void isValideCoordateLigne(final int numberLine, final String line) {
        if (!FIELD_COORDS.matcher(line).matches()) {
            _error.addError(numberLine,"au moins un caractère n'est pas un chiffre, ou manque l'une des coordonnées");
        }
    }
}