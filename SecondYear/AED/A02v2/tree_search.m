clear
clc
close all

fn = "tree_search.txt";
f = fopen(fn);

pessoas = zeros(1, 1900);

tempos0 = zeros(1, 1900);
count0 = 1;

tempos1 = zeros(1, 1900);
count1 = 1;

tempos2 = zeros(1, 1900);
count2 = 1;

tempos3 = zeros(1, 1900);
count3 = 1;
while 1
    tline = fgetl(f);
    if ~ischar(tline), break, end
    data = split(tline);
    pessoa = str2double(data{1,1});
    index = str2double(data{2,1});
    tempo = str2double(data{3,1});

    if index == 0
        pessoas(count0) = pessoa;
        tempos0(count0) = tempo;
        count0 = count0 + 1;
    elseif index == 1
        tempos1(count1) = tempo;
        count1 = count1 + 1;
    elseif index == 2
        tempos2(count2) = tempo;
        count2 = count2 + 1;
    elseif index == 3
        tempos3(count3) = tempo;
        count3 = count3 + 1;
    end
end

loglog(pessoas, tempos0, ".", "Color", "#FFA500")
hold on
loglog(pessoas-pessoas*0.050, tempos1, ".g")
loglog(pessoas+pessoas*0.15, tempos2, ".b")
loglog(pessoas-pessoas*0.105, tempos3, ".", "Color", "red")
hold off
legend("index 0", "index 1", "index 2", "index 3");
xlabel("Number of People")
ylabel("Execution Time")
legend('Location', 'northwest');
title("Tree Search Time")
fclose(f);