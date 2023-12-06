#!/bin/bash

if ! git remote | grep -q "upstream"; then
    git remote add upstream "https://gitlab.com/cable-mc/cobblemon.git"
    echo "Upstream remote added successfully."
else
    echo "Upstream remote already exists."
fi

git fetch upstream
git merge upstream/main

rm -r forge